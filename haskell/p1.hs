absValue :: Int -> Int

absValue n
    | n >= 0    = n
    | otherwise = -n

power :: Int -> Int -> Int 

power x 0 = 1
power x n = x * (power x (n-1))


--auxPrime :: Int -> Int -> Bool




isPrime :: Int -> Bool
isPrime n
    |n == 0 = False
    |n == 1 = False
	|otherwise = auxPrime 2
	where
	    auxPrime p =
	    	| n mod p == 0 = False
	    	| p*p > n = True
	    	| otherwise = auxPrime (p+1) 



slowFib :: Int -> Int

slowFib 0 = 0
slowFib 1 = 1
slowFib n = slowFib (n-1) + slowFib (n-2)

--auxFib :: Int -> Int -> Int 
--
--auxFib f1 f2 n
--    | n = f1 + f2
--    where
--    	(f1,f2) = auxFib (f2+1) f2 (n-1)
--
--
--quickFib :: Int -> Int
--
--quickFib n = fst.auxFib 0 1 n

    	