myLength :: [Int] -> Int 

--auxLenght :: [Int] -> Int -> Int
--
--auxLenght (_:l) n
--  | l == [] = 0
--  | otherwise auxLenght l (n+1)

myLength [] = 0
myLength (x:l) = (myLength l +1)


myMaximum :: [Int] -> Int 

myMaximum (x:l)
    | l == [] = x
    | x > myMaximum l = x
    | otherwise = myMaximum l

average :: [Int] -> Float

average l = (fromIntegral (sumaL l)) / (fromIntegral (myLength l))
    where
        sumaL [] = 0
        sumaL (x:l) = x + sumaL l


buildPalindrome :: [Int] -> [Int] 

buildPalindrome l = (reverseL l) ++ l
    where
        reverseL [] = []
        reverseL (x:l) = reverseL l ++ [x]

remove :: [Int] -> [Int] -> [Int]

remove [] _ = []
remove lst (y:rem) = remove(removeElem y lst []) rem
    where
        removeElem _ [] _ = []
        removeElem y (x:lst) h
            | y == x = h ++ (removeElem y lst h)
            | otherwise = removeElem y lst g
            where
                g = h ++ [x]
                --preguntar


flatten :: [[Int]] -> [Int]

flatten [] = []
flatten (x:xs) = x ++ (flatten xs)

oddsNevens :: [Int] -> ([Int],[Int])

oddsNevens [] = ([],[])
oddsNevens (x:lst)
    | mod x 2 == 0 = ([x] ++ odds, evens) (snd oddsNevens lst)
    | otherwise = [x] ++ (fst oddsNevens lst) --preguntar
    where
        odds = 