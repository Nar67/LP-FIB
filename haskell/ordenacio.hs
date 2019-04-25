insert :: [Int] -> Int -> [Int]
insert [] x = [x]
insert (x:xs) y 
    | y < x = [y] ++ [x] ++ xs
    | otherwise = [x] ++ insert xs y

isort :: [Int] -> [Int]
isort [] = []
isort (x:xs) = insert (isort xs) x

remove :: [Int] -> Int -> [Int]
remove [] _ = []
remove (x:xs) y
    | x == y = xs
    |otherwise = [x] ++ remove xs y

ssort :: [Int] -> [Int]
ssort [] = []
ssort xs = [min] ++ (ssort (remove xs min))
    where
        min = minimum xs

merge :: [Int] -> [Int] -> [Int]
merge _ [] = _
merge (x:xs) (y:ys) 
    | x < y = [x] ++ (merge xs ([y] ++ ys)
    | otherwise = [y] ++ (merge ys ([x] ++ xs)