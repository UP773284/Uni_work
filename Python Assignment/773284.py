from graphics import *

def main():
    size, colours = get_inputs()
    win, patches = size_option(size, colours)

def get_inputs():
    grid_sizes = ["5", "7", "9"]
    size = ""

    while size not in grid_sizes:
        size = input("\nEnter value for the height and width (5, 7, or 9): ")

        size = size.replace(" ", "")[0] #remove gaps and spaces

        if size in grid_sizes: 
            print("You have chosen {0}x{0}.".format(size))
        else:
            print("Invalid option.")


    #colour dictionary 
    valid_colours = ("red","blue","green","magenta","orange","cyan")
    #make a dictionary for short colors
    short = {"r":"red","g":"green","b":"blue","c":"cyan","m":"magenta","o":"orange"}
    colours = []

    while len(colours) < 3:
        colour = input(" Choose colour from red, green, blue, magenta, orange, or cyan: ")
        # Remove whitespace
        colour = colour.replace(" ", "")

        #if color is in valid colors then add it in color
        if colour in valid_colours:
            colours.append(colour)
            print("Colour entry is {0}.".format(colour))  

        #add another condition for short form of color to be valid
        elif short[colour] in valid_colours:
            colours.append(short[colour])
            print("Colour entry is {0}.".format(short[colour])) 
        #otherwise error of color is invalid
        else:
            print("Error: You have not chosen a valid colour.")

    return int(size), colours


def size_option(size, colours):
    size = size * 100
    win = GraphWin("773284", size, size)
    win.setBackground("white")
    patches = []

    for row in range(0, size, 100):
        for column in range(0, size, 100):
            colour = pick_colour(column, row, size, colours)

            if row == column:
                patch = draw_second_patch(win, column, row, colour)
            else:
                patch = draw_first_patch(win, column, row, colour)

            patches.append(patch)

    return win, patches


def pick_colour(column, row, size, colours):
    if 100 <= row <= size - 200 and 100 <= column <= size - 200:
        colour = colours[2]
    elif row % 200 == 0 and column % 200 == 0:
        colour = colours[0]
    else:
        colour = colours[1]

    return colour


def draw_first_patch(win, x, y, colour):
    patch_shapes = []

    #draw circle for even row first which is open in bottom right
    for row in range(0, 100, 40):
        for column in range(0, 100, 20):
            #draw a circle of given color
            circle = Circle(Point(x + column + 10, y + row + 10), 9)
            circle.setFill(colour)
            #draw a rectancle at bottom right corner of white color
            sqr=Rectangle(Point(x + column+10, y + row+10),
                               Point(x + column + 20, y + row + 20))

            sqr.setFill("white")
            #now combine both shapes and its 3/4th of circle 
            for shape in [circle,sqr]:
                patch_shapes.append(shape)

            patch_box = draw_patch_box(x, y)
    
    #draw circle for even row first which is open in top left
    for row in range(20, 100, 40):
        for column in range(0, 100, 20):
            #draw a circle of given color
            circle = Circle(Point(x + column + 10, y + row + 10), 9)
            circle.setFill(colour)
            #draw a rectancle at top left corner of white color
            sqr=Rectangle(Point(x + column, y + row),
                               Point(x + column + 10, y + row + 10))

            sqr.setFill("white")
            #now combine both shapes and its 3/4th of circle 
            for shape in [circle,sqr]:
                patch_shapes.append(shape)

            patch_box = draw_patch_box(x, y)

    # Loop through the rows and columns of the patch
    # to define the square, tilted square, and inner circle
    for row in range(0, 100, 20):
        for column in range(0, 100, 20):
            square = Rectangle(Point(x + column, y + row),
                               Point(x + column + 20, y + row + 20))

            # if suqare is at row+column=odd position then place rectangle here filled with color
            if ((row//20)+(column//20))%2==1:
                square.setFill(colour)
            #draw shape
            for shape in [square]:
                patch_shapes.append(shape)

            patch_box = draw_patch_box(x, y)
    

    for shape in patch_shapes:
        shape.draw(win).setOutline("")

    drawn, design, elements = True, "1", [patch_box, patch_shapes]
    return [colour, drawn, design, x, y, elements]


def draw_second_patch(win, x, y, colour):
    patch_shapes = []

    # Loop through the row and draw rectangle in alternate 
    for i in range(0, 100, 20):
        # Define rectangle in row
        rect = Rectangle(Point(x, y+i), Point(x +100-i, y +i+ 10))
        #add it into shapes to draw
        patch_shapes.append(rect)
        patch_box = draw_patch_box(x, y)
    
    # Loop through the column and draw rectangle in alternate 
    for i in range(0, 100, 20):
        # Define rectangle in row
        rect = Rectangle(Point(x+i+10, y+90-i), Point(x+i+20, y+100))
        #add it into shapes to draw
        patch_shapes.append(rect)
        patch_box = draw_patch_box(x, y)

    for shape in patch_shapes:
        shape.draw(win).setFill(colour)

    drawn, design, elements = True, "2", [patch_box, patch_shapes]
    return [colour, drawn, design, x, y, elements]


def draw_patch_box(x, y):
    patch_box = Rectangle(Point(x, y), Point(x + 100, y + 100))
    patch_box.setWidth(5)
    return patch_box

def get_click(win):
    click = win.getMouse()
    nearest_x, nearest_y = math.floor(click.getX() / 100) * 100, \
        math.floor(click.getY() / 100) * 100
    return nearest_x, nearest_y

    win.getMouse()
    win.close()

main()