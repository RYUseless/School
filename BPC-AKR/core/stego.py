from encoder import Encoder
from decoder import Decoder


# made with love
while True:
    try:
            a = int(input("Choose what you want to do:\n"  #here you choose what you want to do
                      "1. Encode\n2. Decode\n3. Exit\n"))

            if (a > 3):
                raise ValueError
            if (a==1):                      #if you choose encoding, the default file provided for hiding messages into
                enc = Encoder()             #is called clean.png, use this when asked for the first file input, you can encode into .png only
                print("Encoding message")
                enc.encode()
                print("Message successfully encoded\n")     #at the end you need to choose new name for the file with hidden message
                                                            #it needs to have an extension, only .png works
                                                            #you will also see the hash for the old and new file
            elif (a==2):
                dec = Decoder()
                dec.decode()                                #when asked for input, select the new encoded file with .png extension
                print("Message successfully decoded")       #hidden message will be shown, along with the hash
                dec.show_decoded_output()                   #you can compare the messages and hashes from both enc and dec files

            elif (a==3):         #this simply ends the program
                break

    except ValueError:
            print('Please choose correct option')