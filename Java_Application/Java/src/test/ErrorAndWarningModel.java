/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Florian
 */
public class ErrorAndWarningModel extends AbstractListModel
{
    private final List<String> infoPanelList; 

    public ErrorAndWarningModel(List<String> infoPanelList)
    {
        this.infoPanelList = infoPanelList;
    }
    
    @Override
    public int getSize()
    {
        return infoPanelList.size();
    }

    @Override
    public Object getElementAt(int index)
    {
        return infoPanelList.get(index);
    }
    
}
