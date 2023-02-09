print("log_info_start: GUI pokus v2")
#TODO:// PRIDAT TLACITKA: ULOZIT VYGENEROVANE TLACITKO A SROVNAT VZHLED
#TODO:// dodelat funkci, aby na encode se nahodil obrazek co se encoduje a pak finalni picture
#TODO:// spis predelat styl, jak mam nyni rozdelane prohazovani default obrazku na vybrany obrazek
import tkinter as tk
from tkinter import filedialog
from PIL import ImageTk, Image
import os
import webbrowser

#GUI--------------------------------------------------------------------------------------------------------------------
master_gui = tk.Tk()
master_gui.title("GUI-ver:0.2.2") #TODO: udelat classy na setup barevnosti oken atd, at to nemusi byt tu :)
screen_width = master_gui.winfo_screenwidth()
screen_height = master_gui.winfo_screenheight()
if screen_width <= 1920 and screen_height <= 1080:
    size_window = "{a}x{b}".format(a=int(screen_width * 0.6),b=int(screen_height * 0.6))
    print("screen should be 1920x1080 or less")
else:
    size_window = "{a}x{b}".format(a=int(screen_width * 0.52),b=int(screen_height * 0.55))
    print("screen should be higher than full hd")
#TODO: doladit rozliseni a min a max
master_gui.geometry(size_window)
master_gui.configure(bg='#2d2d2d')
master_gui.resizable(False, False)
print(f"{size_window=}") #pak oddelat


#Upper_toolbar----------------------------------------------------------------------------------------------------------
toolbar = tk.Frame(master_gui,highlightbackground='black', highlightthickness=1.5, bg='#232323')
toolbar.pack(side=tk.TOP, fill=tk.X)
#Lower toolbar----------------------------------------------------------------------------------------------------------
toolbar_down = tk.Frame(master_gui,highlightbackground='black', highlightthickness=1.5, bg='#232323')
toolbar_down.pack(side=tk.BOTTOM, fill=tk.X)
#Action bar-------------------------------------------------------------------------------------------------------------
action_bar = tk.Frame(master_gui, bg='#2d2d2d',height=70)
action_bar.pack(side=tk.BOTTOM, fill=tk.X)
#DEF START--------------------------------------------------------------------------------------------------------------
def exit_gui_window(): #exit_button_popup
    print("log_info: oppenning 'exit_gui_window' child window")
    #button_exit['state'] = tk.DISABLED
    exit_window_gui = tk.Toplevel(master_gui)
    exit_window_gui.resizable(False, False)
    exit_window_gui.grab_set()
    exit_window_gui.title("")
    size_window_exit = "{a}x{b}".format(a=int(screen_width * 0.23), b = int(screen_height * 0.13)) # for 1440p
    exit_window_gui.geometry(size_window_exit)
    exit_window_gui.configure(bg='#2d2d2d')
    tk.Label(exit_window_gui, text="Are you sure, that u wanna exist?", bg='#2d2d2d', fg='white', height=2).pack()
    button_menu0 = tk.Button(exit_window_gui, text='Close application',height=3,width=20, bg='#b0161d', fg='white',command= lambda: exit("log_info_end: ending whole GUI"))
    #change for 1080p screens later :)
    button_menu0.pack(side=tk.RIGHT)
    button_menu1 = tk.Button(exit_window_gui, text='Cancel', height=3, width=20, bg='#323232', fg='white',command= lambda: exit_window_gui.destroy() or exit_window_gui.grab_release())
    button_menu1.pack(side=tk.LEFT)

counter = 0 #pro zobrazovani a schovavani add_text_that_u_wanna_hide button
def decode_button():
    print("log_info: encode button actions start here...")
    global counter
    if counter > 0:
        text_mess_button.pack_forget()
        save_encrypted_picture.pack_forget()
        canvas_decrypt.pack(side=tk.RIGHT, anchor=tk.N)
        canvas_decrypt1.pack(side=tk.LEFT, anchor=tk.N)
        canvas_decrypt.create_image(5, 5, anchor=tk.NW, image=new_image)
        canvas_decrypt1.create_image(5, 5, anchor=tk.NW, image=new_image)
        counter -= 1
def encode_button():
    global counter
    print("log_info: decode button actions start here...")
    if counter == 0:
        text_mess_button.pack(side=tk.LEFT,padx=10,pady=10, anchor=tk.W)
        text_mess_button.config(height=1, width=41)
        save_encrypted_picture.pack(side=tk.RIGHT,padx=10,pady=10, anchor=tk.E)
        save_encrypted_picture.config(height=1, width=41)
        #--------------------------------------------------------------------------------------------------
        canvas_decrypt.pack_forget() #dodelat, aby se to pustilo jedině, když bude pridany novy obrazek
        canvas_decrypt1.pack_forget()
        #--------------------------------------------------------------------------------------------------

        counter += 1
file_path = ""
def select_file():
    global file_path
    file_path = filedialog.askopenfilename()
    if file_path:
        print("log_info: your file's path: " + file_path)
        image_name = os.path.basename(file_path)
        print("log_info: your file's name: " + image_name)
        path_display.config(text=file_path)

def add_picture():  #on button click changes the picture
    global selected_image
    img = (Image.open(file_path))
    resized_image = img.resize((550,550))
    selected_image = ImageTk.PhotoImage(resized_image)
    canvas_decrypt.itemconfig(canvas_decrypt_image, image = selected_image)
    canvas_decrypt1.itemconfig(canvas_decrypt_image1, image = selected_image)
def add_pic_button():
    global path_display
    global file_path
    print("log_info: add picture address def")
    print(image_name)
    add_pic_gui = tk.Toplevel(master_gui)
    add_pic_gui.resizable(False,False)
    add_pic_gui.grab_set()
    add_pic_gui.geometry("650x100")
    add_pic_gui.configure(bg='#2d2d2d')
    add_address_bar0 = tk.Frame(add_pic_gui, highlightbackground='#2d2d2d', highlightthickness=1.5, bg='#2d2d2d')
    path_description = tk.Label(add_address_bar0, text='File path: ')
    add_iamge = tk.Button(add_address_bar0, text='Add image', bg='#2d2d2d', fg='white', command=lambda:add_picture()) # add picture button
    path_display = tk.Label(add_address_bar0, text=file_path, width=50)
    file_select = tk.Button(add_address_bar0, text='Select file', bg='#2d2d2d', fg='white', command=lambda:select_file())
    exit = tk.Button(add_address_bar0, text='Exit', bg='#2d2d2d', fg='white', command=add_pic_gui.destroy, padx=2.5, pady=2.5)
    path_description.grid(row = 0, column = 0, pady = 5, padx = 5)
    add_iamge.grid(row = 2, column= 0)
    path_display.grid(row = 0, column = 1)
    file_select.grid(row = 1, column = 0) 
    exit.grid(row = 1, column = 2, pady = 5)
    add_address_bar0.grid(row = 0, column= 0)
#DEF END----------------------------------------------------------------------------------------------------------------

#visible buttons--------------------------------------------------------------------------------------------------------
button_menu0 = tk.Button(toolbar, text='Add picture', bg='#323232', fg='white',command=add_pic_button) #add picture button
button_menu1 = tk.Button(toolbar, text='DECODE', bg='#323232', fg='white', command=decode_button) #decode button
button_menu2 = tk.Button(toolbar, text='ENCODE', bg='#323232', fg='white', command= encode_button) #encode button
button_menu3 = tk.Button(toolbar, text='Help', bg='#323232', fg='white', command= lambda: webbrowser.open_new('https://youtu.be/dQw4w9WgXcQ')) #log wiev button
button_exit = tk.Button(toolbar_down, font='Comic-sans', text="Exit", command= exit_gui_window) #Exit the whole gui button
button_menu0.pack(side=tk.LEFT, padx=10, pady=10)
button_menu1.pack(side=tk.LEFT, padx=10, pady=10)
button_menu2.pack(side=tk.LEFT, padx=10, pady=10)
button_menu3.pack(side=tk.RIGHT, padx=10, pady=10)
button_exit.pack(side=tk.BOTTOM, padx=10, pady=10)
#hiden by when start----------------------------------------------------------------------------------------------------
text_mess_button = tk.Button(action_bar, text='Add text that you wanna hide!', bg='#323232', fg='white')#pop-up buttun when 'encode' is pressed
save_encrypted_picture = tk.Button(action_bar, text='Save encrypted picture', bg='#323232', fg='white')
#decrypted picture canvas-----------------------------------------------------------------------------------------------
image_name = "empty.png"
image_path = os.path.abspath(image_name)
img= (Image.open(image_path))
canvas_decrypt= tk.Canvas(master_gui, width= 550, height= 550)
canvas_decrypt.pack(side=tk.RIGHT, anchor=tk.N)
resized_image= img.resize((550,550)) #Image.ANTIALIAS removed, because of the support end
new_image= ImageTk.PhotoImage(resized_image)
canvas_decrypt_image = canvas_decrypt.create_image(5,5, anchor=tk.NW, image=new_image)
#end decrypted picture canvas-------------------------------------------------------------------------------------------
canvas_decrypt1= tk.Canvas(master_gui, width= 550, height= 550) #pokus
canvas_decrypt1.pack(side=tk.LEFT, anchor=tk.N)
canvas_decrypt_image1 = canvas_decrypt1.create_image(5,5, anchor=tk.NW, image=new_image)
#issue: nejde zapnout program, aniz by nebyla zadana cesta k obrazku, napada me jako fix mit docasne otevrene empty.png a pak jen prehodit cestu
#...ale idk jestli to prohodit i legit obrazek v gui

#END of the master-gui--------------------------------------------------------------------------------------------------
master_gui.mainloop()
