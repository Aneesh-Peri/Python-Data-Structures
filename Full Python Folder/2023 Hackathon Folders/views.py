from flask import Blueprint, redirect, url_for

views = Blueprint(__name__,"views")


@views.route("/home")
def home():
   return "Welcome to our app, "

@views.route("/about")
def about():
    return "Hello! Below are your developers of our app,\n "

@views.route("how-to-get-started")
def how_to_get_started():
    return redirect(url_for("home"))