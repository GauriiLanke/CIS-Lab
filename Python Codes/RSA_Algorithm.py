# Assignment 4: RSA Algorithm

def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a

def multiplicative_inverse(e, phi):
    # Extended Euclidean Algorithm
    old_r, r = phi, e
    old_s, s = 1, 0
    old_t, t = 0, 1
    
    while r != 0:
        quotient = old_r // r
        old_r, r = r, old_r - quotient * r
        old_s, s = s, old_s - quotient * s
        old_t, t = t, old_t - quotient * t
    return old_t % phi

def generate_keys(p, q, e):
    n = p * q
    phi = (p - 1) * (q - 1)

    if gcd(e, phi) != 1:
        raise ValueError("e and φ(n) must be coprime!")

    d = multiplicative_inverse(e, phi)
    print("Value of d: ", d)
    return (e, n), (d, n)

def encrypt(plaintext, public_key):
    e, n = public_key
    return pow(plaintext, e, n)

def decrypt(ciphertext, private_key):
    d, n = private_key
    return pow(ciphertext, d, n)

p = int(input("Enter first prime number (p): "))
q = int(input("Enter second prime number (q): "))

n = p * q
phi = (p - 1) * (q - 1)
print(f"\nCalculated values:")
print("n = ",n)
print("φ(n) = ",phi)

while True:
    e = int(input("\nEnter value of e (must be coprime with φ(n)): "))
    if gcd(e, phi) == 1:
        break
    else:
        print(f"Invalid choice! {e} is not coprime with φ(n). Try again.")

public_key, private_key = generate_keys(p, q, e)
print("\nPublic Key (e, n):", public_key)
print("Private Key (d, n):", private_key)

plaintext = int(input("\nEnter plaintext number to encrypt: "))
#Encryption
ciphertext = encrypt(plaintext, public_key)
print("Ciphertext:", ciphertext)

#Decryption
decrypted = decrypt(ciphertext, private_key)
print("Decrypted Text:", decrypted)




# # Assignment 4: RSA Algorithm with String Support (Clean Version)

# def gcd(a, b):
#     while b != 0:
#         a, b = b, a % b
#     return a

# def multiplicative_inverse(e, phi):
#     # Extended Euclidean Algorithm
#     old_r, r = phi, e
#     old_s, s = 1, 0
#     old_t, t = 0, 1
    
#     while r != 0:
#         quotient = old_r // r
#         old_r, r = r, old_r - quotient * r
#         old_s, s = s, old_s - quotient * s
#         old_t, t = t, old_t - quotient * t
#     return old_t % phi

# def generate_keys(p, q, e):
#     n = p * q
#     phi = (p - 1) * (q - 1)

#     if gcd(e, phi) != 1:
#         raise ValueError("e and φ(n) must be coprime!")

#     d = multiplicative_inverse(e, phi)
#     print("Value of d:", d)
#     return (e, n), (d, n), n, phi

# def encrypt(plaintext, public_key):
#     e, n = public_key
#     return [pow(ord(char), e, n) for char in plaintext]  # Encrypt each character

# def decrypt(ciphertext, private_key):
#     d, n = private_key
#     return ''.join([chr(pow(char, d, n)) for char in ciphertext])  # Decrypt each number

# p = int(input("Enter first prime number (p): "))
# q = int(input("Enter second prime number (q): "))

# # Choose e
# while True:
#     e = int(input("\nEnter value of e (must be coprime with φ(n)): "))
#     phi_test = (p - 1) * (q - 1)
#     if gcd(e, phi_test) == 1:
#         break
#     else:
#         print(f"Invalid choice! {e} is not coprime with φ(n). Try again.")

# # Generate keys and get n, phi
# public_key, private_key, n, phi = generate_keys(p, q, e)

# print(f"\nCalculated values:")
# print("n =", n)
# print("φ(n) =", phi)
# print("\nPublic Key (e, n):", public_key)
# print("Private Key (d, n):", private_key)

# # Encrypt message
# plaintext = input("\nEnter plaintext string to encrypt: ")
# ciphertext = encrypt(plaintext, public_key)
# print("Ciphertext (array of encrypted ASCII):", ciphertext)

# # Decrypt message
# decrypted = decrypt(ciphertext, private_key)
# print("Decrypted Text:", decrypted)




# Assignment 4: RSA Algorithm with Hexadecimal Ciphertext

# def gcd(a, b):
#     while b != 0:
#         a, b = b, a % b
#     return a

# def multiplicative_inverse(e, phi):
#     old_r, r = phi, e
#     old_s, s = 1, 0
#     old_t, t = 0, 1
    
#     while r != 0:
#         quotient = old_r // r
#         old_r, r = r, old_r - quotient * r
#         old_s, s = s, old_s - quotient * s
#         old_t, t = t, old_t - quotient * t
#     return old_t % phi

# def generate_keys(p, q, e):
#     n = p * q
#     phi = (p - 1) * (q - 1)
#     if gcd(e, phi) != 1:
#         raise ValueError("e and φ(n) must be coprime!")
#     d = multiplicative_inverse(e, phi)
#     print("Value of d:", d)
#     return (e, n), (d, n), n, phi

# def encrypt(plaintext, public_key):
#     e, n = public_key
#     # Convert each char -> ASCII -> encrypt -> hex
#     return [format(pow(ord(char), e, n), 'x') for char in plaintext]

# def decrypt(ciphertext_hex, private_key):
#     d, n = private_key
#     # Convert hex -> int -> decrypt -> char
#     return ''.join([chr(pow(int(hex_val, 16), d, n)) for hex_val in ciphertext_hex])

# # Input primes
# p = int(input("Enter first prime number (p): "))
# q = int(input("Enter second prime number (q): "))

# # Choose e
# while True:
#     e = int(input("\nEnter value of e (must be coprime with φ(n)): "))
#     phi_test = (p - 1) * (q - 1)
#     if gcd(e, phi_test) == 1:
#         break
#     else:
#         print(f"Invalid choice! {e} is not coprime with φ(n). Try again.")

# # Generate keys
# public_key, private_key, n, phi = generate_keys(p, q, e)

# print(f"\nCalculated values:")
# print("n =", n)
# print("φ(n) =", phi)
# print("\nPublic Key (e, n):", public_key)
# print("Private Key (d, n):", private_key)

# # Encrypt message
# plaintext = input("\nEnter plaintext string to encrypt: ")
# ciphertext_hex = encrypt(plaintext, public_key)
# print("Ciphertext (hexadecimal):", ciphertext_hex)

# # Decrypt message
# decrypted = decrypt(ciphertext_hex, private_key)
# print("Decrypted Text:", decrypted)
