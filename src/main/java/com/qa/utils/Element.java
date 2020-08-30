package com.qa.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;

public interface Element extends WebElement, WrapsElement, Locatable {
    boolean elementWired();
}