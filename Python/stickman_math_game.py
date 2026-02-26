"""Stickman Math Runner

A lightweight educational arcade game inspired by simple stickman runners.
The player controls a stickman and collides with answer targets to solve
5th-grade level math questions while earning points.

Requirements:
    pip install pygame
Run:
    python Python/stickman_math_game.py
"""

from __future__ import annotations

import random
import sys
from dataclasses import dataclass
from typing import List, Tuple

import pygame


WIDTH, HEIGHT = 1000, 560
FPS = 60
LANE_Y = [160, 280, 400]
BG_COLOR = (18, 22, 36)
WHITE = (245, 245, 245)
GREEN = (50, 200, 120)
RED = (220, 80, 80)
GOLD = (255, 205, 60)
BLUE = (80, 130, 250)
GRAY = (140, 145, 160)


@dataclass
class MathQuestion:
    prompt: str
    correct_answer: int
    options: List[int]


def make_question() -> MathQuestion:
    """Generate a 5th-grade style arithmetic question with 3 options."""
    topic = random.choice(
        [
            "add_sub",   # multi-digit addition/subtraction
            "mul",       # multiplication facts
            "div",       # division with whole-number results
            "order",     # mixed operations order of operations
            "area",      # rectangle area
            "factors",   # factor identification
        ]
    )

    if topic == "add_sub":
        if random.random() < 0.5:
            a, b = random.randint(100, 999), random.randint(100, 999)
            prompt = f"{a} + {b} = ?"
            answer = a + b
        else:
            a, b = random.randint(200, 999), random.randint(100, 199)
            prompt = f"{a} - {b} = ?"
            answer = a - b
    elif topic == "mul":
        a, b = random.randint(2, 12), random.randint(2, 12)
        prompt = f"{a} × {b} = ?"
        answer = a * b
    elif topic == "div":
        b = random.randint(2, 12)
        answer = random.randint(2, 12)
        a = b * answer
        prompt = f"{a} ÷ {b} = ?"
    elif topic == "order":
        a, b, c = random.randint(2, 20), random.randint(2, 12), random.randint(2, 9)
        prompt = f"{a} + {b} × {c} = ?"
        answer = a + b * c
    elif topic == "area":
        l, w = random.randint(2, 20), random.randint(2, 20)
        prompt = f"Area of {l} by {w} rectangle = ?"
        answer = l * w
    else:
        n = random.randint(20, 80)
        factors = [x for x in range(2, 13) if n % x == 0]
        if factors:
            answer = random.choice(factors)
            prompt = f"Which is a factor of {n}?"
        else:
            # fallback to multiplication if prime-like for this range
            a, b = random.randint(2, 12), random.randint(2, 12)
            prompt = f"{a} × {b} = ?"
            answer = a * b

    options = {answer}
    while len(options) < 3:
        delta = random.randint(-20, 20)
        candidate = answer + delta
        if candidate != answer and candidate >= 0:
            options.add(candidate)

    option_list = list(options)
    random.shuffle(option_list)
    return MathQuestion(prompt=prompt, correct_answer=answer, options=option_list)


class Stickman:
    def __init__(self) -> None:
        self.x = 170
        self.lane = 1
        self.radius = 20

    @property
    def y(self) -> int:
        return LANE_Y[self.lane]

    def move_up(self) -> None:
        self.lane = max(0, self.lane - 1)

    def move_down(self) -> None:
        self.lane = min(2, self.lane + 1)

    def draw(self, screen: pygame.Surface) -> None:
        y = self.y
        # head
        pygame.draw.circle(screen, WHITE, (self.x, y - 42), 14, 3)
        # torso
        pygame.draw.line(screen, WHITE, (self.x, y - 28), (self.x, y + 12), 3)
        # arms
        pygame.draw.line(screen, WHITE, (self.x - 18, y - 12), (self.x + 18, y - 18), 3)
        # legs
        pygame.draw.line(screen, WHITE, (self.x, y + 12), (self.x - 14, y + 38), 3)
        pygame.draw.line(screen, WHITE, (self.x, y + 12), (self.x + 14, y + 38), 3)

    def hitbox(self) -> pygame.Rect:
        return pygame.Rect(self.x - 22, self.y - 56, 44, 96)


class OptionTarget:
    def __init__(self, lane: int, value: int, is_correct: bool, start_x: int) -> None:
        self.lane = lane
        self.value = value
        self.is_correct = is_correct
        self.x = float(start_x)
        self.speed = 4.2
        self.width = 120
        self.height = 64

    @property
    def y(self) -> int:
        return LANE_Y[self.lane]

    def update(self) -> None:
        self.x -= self.speed

    def draw(self, screen: pygame.Surface, font: pygame.font.Font) -> None:
        color = BLUE if self.is_correct else GRAY
        rect = self.rect()
        pygame.draw.rect(screen, color, rect, border_radius=10)
        pygame.draw.rect(screen, WHITE, rect, 2, border_radius=10)
        txt = font.render(str(self.value), True, WHITE)
        screen.blit(txt, txt.get_rect(center=rect.center))

    def rect(self) -> pygame.Rect:
        return pygame.Rect(int(self.x), self.y - self.height // 2, self.width, self.height)


class Game:
    def __init__(self) -> None:
        pygame.init()
        pygame.display.set_caption("Stickman Math Runner")
        self.screen = pygame.display.set_mode((WIDTH, HEIGHT))
        self.clock = pygame.time.Clock()
        self.ui_font = pygame.font.SysFont("arial", 28)
        self.big_font = pygame.font.SysFont("arial", 42, bold=True)

        self.player = Stickman()
        self.score = 0
        self.combo = 0
        self.lives = 3
        self.question_number = 1
        self.current_question = make_question()
        self.targets = self._make_targets(self.current_question)
        self.cooldown_ms = 0
        self.running = True

    def _make_targets(self, question: MathQuestion) -> List[OptionTarget]:
        lanes = [0, 1, 2]
        random.shuffle(lanes)
        targets = []
        for i, value in enumerate(question.options):
            targets.append(
                OptionTarget(
                    lane=lanes[i],
                    value=value,
                    is_correct=(value == question.correct_answer),
                    start_x=WIDTH + 70,
                )
            )
        return targets

    def _next_question(self) -> None:
        self.question_number += 1
        self.current_question = make_question()
        self.targets = self._make_targets(self.current_question)

    def _evaluate_collision(self, target: OptionTarget) -> None:
        if target.is_correct:
            self.combo += 1
            gained = 10 + (self.combo - 1) * 2
            self.score += gained
        else:
            self.combo = 0
            self.lives -= 1
            self.score = max(0, self.score - 5)

        self.cooldown_ms = 500
        self._next_question()

    def update(self, dt_ms: int) -> None:
        if self.cooldown_ms > 0:
            self.cooldown_ms = max(0, self.cooldown_ms - dt_ms)

        for target in self.targets:
            target.update()

        # if answers pass by without selection, count as miss
        if all(target.x + target.width < 0 for target in self.targets):
            self.combo = 0
            self.lives -= 1
            self._next_question()

        if self.cooldown_ms == 0:
            player_box = self.player.hitbox()
            for target in self.targets:
                if player_box.colliderect(target.rect()):
                    self._evaluate_collision(target)
                    break

        if self.lives <= 0:
            self.running = False

    def draw(self) -> None:
        self.screen.fill(BG_COLOR)

        for lane_y in LANE_Y:
            pygame.draw.line(self.screen, (35, 43, 68), (0, lane_y + 52), (WIDTH, lane_y + 52), 2)

        question_txt = self.ui_font.render(
            f"Q{self.question_number}: {self.current_question.prompt}", True, GOLD
        )
        self.screen.blit(question_txt, (24, 24))

        hud = self.ui_font.render(
            f"Score: {self.score}   Combo: {self.combo}   Lives: {self.lives}", True, GREEN
        )
        self.screen.blit(hud, (24, 66))

        controls = self.ui_font.render("Use ↑ and ↓ to move lanes", True, WHITE)
        self.screen.blit(controls, (24, HEIGHT - 42))

        self.player.draw(self.screen)
        for target in self.targets:
            target.draw(self.screen, self.ui_font)

        pygame.display.flip()

    def game_over_screen(self) -> None:
        waiting = True
        while waiting:
            self.screen.fill((12, 15, 24))
            over = self.big_font.render("Game Over", True, RED)
            score = self.ui_font.render(f"Final Score: {self.score}", True, WHITE)
            tips = self.ui_font.render("Press R to restart or Q to quit", True, GRAY)

            self.screen.blit(over, over.get_rect(center=(WIDTH // 2, HEIGHT // 2 - 50)))
            self.screen.blit(score, score.get_rect(center=(WIDTH // 2, HEIGHT // 2 + 5)))
            self.screen.blit(tips, tips.get_rect(center=(WIDTH // 2, HEIGHT // 2 + 52)))
            pygame.display.flip()

            for event in pygame.event.get():
                if event.type == pygame.QUIT:
                    pygame.quit()
                    sys.exit(0)
                if event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_q:
                        pygame.quit()
                        sys.exit(0)
                    if event.key == pygame.K_r:
                        self.__init__()
                        return

            self.clock.tick(FPS)

    def run(self) -> None:
        while True:
            while self.running:
                dt_ms = self.clock.tick(FPS)
                for event in pygame.event.get():
                    if event.type == pygame.QUIT:
                        pygame.quit()
                        return
                    if event.type == pygame.KEYDOWN:
                        if event.key in (pygame.K_w, pygame.K_UP):
                            self.player.move_up()
                        if event.key in (pygame.K_s, pygame.K_DOWN):
                            self.player.move_down()

                self.update(dt_ms)
                self.draw()

            self.game_over_screen()


if __name__ == "__main__":
    Game().run()
