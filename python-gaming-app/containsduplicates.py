class Duplicates:
    def containsDuplicate(self, nums: list[int])->bool:
        hashset = set()
        for n in nums:
            print("n:{}".format(n))
            if n in hashset:
                return True
            hashset.add(n)
        return False


if __name__=="__main__":
    import doctest
    doctest.testmod()
    d =  Duplicates()
    du = d.containsDuplicate([4,8,0,3,4,5,7,8])
    print("duplicate :{}".format(du))