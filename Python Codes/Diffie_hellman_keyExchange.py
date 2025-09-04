# # Diffie-Hellman Key Exchange Algorithm

# p = int(input("Enter a prime number (p): "))
# g = int(input("Enter a primitive root (g): "))

# # Private keys 
# a = int(input("Enter User A private key (a): "))
# b = int(input("Enter User B private key (b): "))

# # Public keys
# A = pow(g, a, p)  # (g^a) mod p
# B = pow(g, b, p)  # (g^b) mod p

# print(f"\nUser A Public Key (A): {A}")
# print(f"User B Public Key (B): {B}")

# # Secret keys
# secret_A = pow(B, a, p)  # (B^a) mod p
# secret_B = pow(A, b, p)  # (A^b) mod p

# print(f"\nAlice's Shared Secret: {secret_A}")
# print(f"Bob's Shared Secret: {secret_B}")

# if secret_A == secret_B:
#     print("\nKey Exchange Successful! Shared secret established.")
# else:
#     print("\nKey Exchange Failed!")


# Diffie-Hellman Key Exchange Algorithm with Auto Primitive Root

# Calculate GCD 
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

# Find primitive root of prime p
def find_primitive_root(p):
    # The set of numbers from 1 to p-1 that are relatively prime to p
    required_set = set(num for num in range(1, p) if gcd(num, p) == 1)
    for g in range(2, p):  # Primitive roots are in range [2, p-1]
        actual_set = set(pow(g, powers, p) for powers in range(1, p))
        if required_set == actual_set:
            return g
    return None

print("\nDiffie-Hellman Key Exchange Algorithm\n")

p = int(input("Enter a prime number (p): "))

# Primitive roots
g = find_primitive_root(p)
if g is None:
    print("No primitive root found for the given prime.")
    exit()
else:
    print(f"Primitive root (g) : {g}")

# Private keys 
a = int(input("\nEnter User A private key (a): "))
b = int(input("Enter User B private key (b): "))

# Public keys
A = pow(g, a, p)  # (g^a) mod p
B = pow(g, b, p)  # (g^b) mod p

print(f"\nUser A Public Key (A): {A}")
print(f"User B Public Key (B): {B}")

# Secret keys
secret_A = pow(B, a, p)  # (B^a) mod p
secret_B = pow(A, b, p)  # (A^b) mod p

print(f"\nUser A's Shared Secret Key: {secret_A}")
print(f"User B's Shared Secret Key: {secret_B}")

if secret_A == secret_B:
    print("\nKey Exchange Successful! Shared secret established.")
else:
    print("\nKey Exchange Failed!")
