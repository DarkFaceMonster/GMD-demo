/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
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
 * #L%
 */
package y.client.application;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.base.validator.RegExValidator;
import gwt.material.design.client.ui.*;
import gwt.material.design.incubator.client.loadingstate.AppLoadingState;
import y.client.application.ApplicationView.Binder;

public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @UiField
    MaterialWindow windowSign_in;
    
    @UiField
    MaterialNavBar navBar, navBarSearch;
    
    @UiField
    MaterialSearch txtSearch;
    
    @UiField
    MaterialButton btnAdd;
    
    @UiField
    MaterialButton btnLogin;
    
    @Inject
    ApplicationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        txtSearch.addCloseHandler(event -> {
            navBar.setVisible(true);
            navBarSearch.setVisible(false);
        });
        txtSearch.addSearchFinishHandler(event -> MaterialToast.fireToast("You search : " + txtSearch.getSelectedObject().getKeyword()));
    }
    
    @UiHandler("btnSearch")
    void onSearch(ClickEvent e) {
        navBar.setVisible(false);
        navBarSearch.setVisible(true);
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        Document.get().getElementById("splashscreen").removeFromParent();
    }

    @UiHandler("btnAdd")
    void onAdd(ClickEvent e) {
    	windowSign_in.open();
        MaterialToast.fireToast("I love GMD");
    }
    
    @UiHandler("btnLogin")
    void onLogin(ClickEvent e) {
    	windowSign_in.close();
    }
}
