# # Diffie-Hellman Key Exchange Algorithm

print("\nDiffie-Hellman Key Exchange Algorithm\n")
q = int(input("Enter a prime number (q): "))
alpha = int(input("Enter a primitive root (alpha): "))

# Private keys 
a = int(input("\nEnter User A private key (a): "))
b = int(input("Enter User B private key (b): "))

# Public keys
A = pow(alpha, a, q)  # (apha^a) mod p
B = pow(alpha, b, q)  # (apha^b) mod p

print(f"\nUser A Public Key (A): {A}")
print(f"User B Public Key (B): {B}")

# Secret keys
secret_A = pow(B, a, q)  # (B^a) mod q
secret_B = pow(A, b, q)  # (A^b) mod q

print(f"\nAlice's Shared Secret Key: {secret_A}")
print(f"Bob's Shared Secret Key: {secret_B}")

if secret_A == secret_B:
    print("\nKey Exchange Successful! Shared secret established.")
else:
    print("\nKey Exchange Failed!")


