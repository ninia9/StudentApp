package com.students.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DeleteMe {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {0,0}, {1,1}, {2,1}, {3,2}, {4,3}, {5,5}, {6,8}
    });
    }

    private int fInput;
    private int fExpected;

    public DeleteMe(int input, int expected){
        this.fInput = input;
        this.fExpected = expected;
    }

    @Test
    public void test() {
        System.out.println(fInput + " " + fExpected);
    }

}
