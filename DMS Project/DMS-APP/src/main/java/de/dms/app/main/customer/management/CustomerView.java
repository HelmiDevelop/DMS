/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dms.app.main.customer.management;

import com.airhacks.afterburner.views.FXMLView;
import java.util.function.Consumer;

/**
 *
 * @author mayel-1
 */
public class CustomerView extends FXMLView{

    @Override
    public void getPresenter(Consumer<Object> presenterConsumer) {
        CustomerPresenter presenter = (CustomerPresenter)this.getPresenter();
        presenterConsumer.accept(presenter);
        presenterConsumer.andThen(new Consumer<Object>() {
            @Override
            public void accept(Object t) {
                presenter.initializeCustomerTableView();
            }
        }).accept(this);
        //super.getPresenter(presenterConsumer); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
