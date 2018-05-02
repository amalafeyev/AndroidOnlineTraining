package com.malafeyev.alexey.mobapp;


/*
 * Copyright 2016, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.app.Activity;
import android.test.suitebuilder.annotation.SmallTest;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.mockito.Mockito.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;
    private Activity aCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
        aCalculator = mock(CalculatorActivity.class);
    }

    @Test
    public void clickButton() {
        // 2. tell the mock how to behave
        when(aCalculator.getActionBar()).thenReturn(null);

        // 3. use the mock
        assertThat(null, is(equalTo(aCalculator.getActionBar())));
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void addTwoNumbersNegative() {
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }

    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.111f, 1.111d);
        //assertThat(resultAdd, is(closeTo(2.222, 0.01)));
        assertThat(resultAdd, is(CoreMatchers. equalTo(2.222d)));
    }

    @Test
    public void subTwoNumbers() {
        double resultAdd = mCalculator.sub(1d, 1d);
        assertThat(resultAdd, is(equalTo(0d)));
    }

    @Test
    public void subTwoNumbersNegative() {
        double resultAdd = mCalculator.sub(-1d, 2d);
        assertThat(resultAdd, is(equalTo(-3d)));
    }

    @Test
    public void mulTwoNumbers() {
        double resultAdd = mCalculator.mul(1d, 1d);
        assertThat(resultAdd, is(equalTo(1d)));
    }

    @Test
    public void mulTwoNumbersNegative() {
        double resultAdd = mCalculator.mul(-2d, 2d);
        assertThat(resultAdd, is(equalTo(-4d)));
    }

    @Test
    public void mulTwoNumbersZero() {
        double resultAdd = mCalculator.mul(-2d, 0d);
        assertThat(resultAdd, is(equalTo(-0d)));
    }

    @Test
    public void divTwoNumbersZero() {
        double resultAdd = mCalculator.div(-2d, 0d);
        assertThat(resultAdd, is(equalTo(Double.NEGATIVE_INFINITY)));
    }

    /**
     * Test for divide by zero; must throw IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void divDivideByZeroThrows() {
        mCalculator.div(32d,0d);
    }


}
