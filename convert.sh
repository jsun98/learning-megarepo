#!/bin/bash

jupyter nbconvert --to markdown */*.ipynb
jupyter nbconvert --to markdown */**/*.ipynb

git add --force */*.md 
git add --force */**/*.md 
