def reverse_words(input:str)->str:
    return "".join(input.split()[::-1])

if __name__=="__main__":
    import doctest
    doctest.testmod()