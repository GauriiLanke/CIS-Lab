#Assignment 2: DES Algorithm 

from Crypto.Cipher import DES
from Crypto.Random import get_random_bytes
import binascii

# Generate a random 8-byte key for DES
key = get_random_bytes(8)   
print("Key:", binascii.hexlify(key).decode())

# Create DES cipher object in ECB mode
cipher = DES.new(key, DES.MODE_ECB)

# Plaintext 
plaintext = b"Gaurii24"   
print("Plaintext:", plaintext.decode())

# Encrypt
ciphertext = cipher.encrypt(plaintext)
print("Encrypted:", binascii.hexlify(ciphertext).decode())

# Decrypt
decipher = DES.new(key, DES.MODE_ECB)
decrypted = decipher.decrypt(ciphertext)
print("Decrypted:", decrypted.decode())
