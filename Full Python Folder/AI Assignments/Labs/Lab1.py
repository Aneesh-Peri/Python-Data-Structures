# Warmup-1 Problems
def sleep_in(weekday, vacation):
    return True if weekday != True or vacation == True else False


def monkey_trouble(a_smile, b_smile):
    return True if a_smile == True and b_smile == True or a_smile == False and b_smile == False else False


def sum_double(a, b):
    return (a + b) * 2 if a == b else print(a + b)


def diff21(n):
    return abs(n - 21) * 2 if n > 21 else print(abs(n - 21))


def parrot_trouble(talking, hour):
    return False if talking == False or 7 <= hour <= 20 else True


def makes10(a, b):
    return True if a == 10 or b == 10 or a + b == 10 else False


def near_hundred(n):
    return True if abs(n - 100) <= 10 or abs(n - 200) <= 10 else False


def pos_neg(a, b, negative):
    return (a < 0 or b < 0) or (negative == True and a < 0 and b < 0)


# String-1 Problems
def hello_name(name):
    return f'Hello {name}!'


def make_abba(a, b):
    return f'{a}{b}{b}{a}'


def make_tags(tag, word):
    return f'<{tag}>{word}</{tag}>'


def make_out_word(out, word):
    return out[:2] + word + out[2:]


def extra_end(str):
    return str[-2:] + str[-2:] + str[-2:]


def first_two(str):
    return str[:2] if len(str) > 2 else str


def first_half(str):
    return str[:len(str) // 2]


def without_end(str):
    return str[1:len(str) - 1]


# List-1 Problems
def first_last6(nums):
    return True if (nums[0] == 6 or nums[-1] == 6) or (nums[0] == '6' or nums[-1] == '6') else False


def same_first_last(lst):
    return True if (len(lst) >= 1 and lst[0] == lst[-1]) else False


def make_pi():
    return [int(digit) for digit in str(round(3.141592653589793, 3)).replace(".", "")[:3]]


def common_end(a, b):
    return True if (a[0] == b[0] or a[-1] == b[-1]) else False


def sum3(nums):
    return sum(nums)


def rotate_left3(nums):
    return nums[1:] + nums[:1]


def reverse3(nums):
    return nums[::-1]


def max_end3(nums):
    return [max(nums[0], nums[-1])] * 3


# Logic-1 Problems
def cigar_party(cigars, is_weekend):
    return True if (40 < cigars < 60 or (is_weekend == True)) else False


def date_fashion(you, date):
    return 2 if you >= 8 or date >= 8 else 0 if you <= 8 and date <= 8 else 1


def squirrel_play(temp, is_summer):
    return True if (60 <= temp <= 90) or (60 <= temp <= 100 and is_summer == True) else False


def caught_speeding(speed, is_birthday):
    return 0 if speed <= 60 + is_birthday * 5 else 1 if speed <= 80 + is_birthday * 5 else 2


def sorta_sum(a, b):
    return 20 if (10 <= a + b <= 19) else a + b


def alarm_clock(day, vacation):
    return '7:00' if (1 <= day <= 5 and vacation == False) else '10:00'


def love6(a, b):
    return True if (abs(a + b) == 6 or a == 6 or b == 6) else False


def in1to10(n, outside_mode):
    return True if (1 <= n <= 10) or (outside_mode == True and n == 1 or n >= 10) else False
