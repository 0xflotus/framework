/*
 * Copyright 2000-2016 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.v7.tests.components.grid;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.customelements.ComboBoxElement;
import com.vaadin.testbench.elements.GridElement.GridEditorElement;
import com.vaadin.testbench.parallel.TestCategory;
import com.vaadin.tests.tb3.MultiBrowserTest;
import com.vaadin.testbench.customelements.GridElement;

@TestCategory("grid")
public class GridEditorCustomFieldTest extends MultiBrowserTest {

    @Test
    public void testCustomFieldWorksInEditorRow() {
        openTestURL();
        GridElement grid = $(GridElement.class).first();
        Assert.assertEquals("Stockholm", grid.getCell(0, 2).getText());
        grid.getCell(0, 1).doubleClick();
        GridEditorElement editor = grid.getEditor();
        TestBenchElement customField = editor.getField(2);

        ComboBoxElement comboBox = customField.$(ComboBoxElement.class).first();
        comboBox.selectByText("Oslo");
        editor.save();
        Assert.assertEquals("Oslo", grid.getCell(0, 2).getText());

    }
}
