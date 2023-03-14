package org.example;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean isValidName;

    public AccountTest(String name, boolean isValidName) {
        this.name = name;
        this.isValidName = isValidName;
    }

    @Parameterized.Parameters(name="{0}")
    public static Object[][] data(){
      return new Object[][] {
              {"Тимоти Шаламе", true},
              {" Тимоти Шаламе", false},
              {"Тимоти Шаламе ", false},
              {"Тимоти  Шаламе", false},
              {"ТимотиШаламе", false},
              {"Тимот1 Шаламе", false},
              {"Т ", false},
              {"Т Ш", true},
              {"Т Шs", true},
              {new Faker().regexify("[А-Я][а-я]{8}\\s[А-Я][а-я]{8}"),true},
              {new Faker().regexify("[А-Я][а-я]{7}\\s[А-Я][а-я]{8}"),true},
              {new Faker().regexify("[А-Я][а-я]{9}\\s[А-Я][а-я]{8}"),false},
      };
    }

    @Test
    public void checkNameToEmboss() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        Assert.assertEquals(isValidName,actual);
    }
}