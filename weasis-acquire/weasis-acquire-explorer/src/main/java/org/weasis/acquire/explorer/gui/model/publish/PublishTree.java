package org.weasis.acquire.explorer.gui.model.publish;

import javax.swing.JScrollPane;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTree;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingListener;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;

public class PublishTree extends JScrollPane {
    private static final long serialVersionUID = -353604550595956677L;

    private final CheckboxTree checkboxTree;
    private final PublishTreeModel publishTreeModel;

    public PublishTree() {
        this.publishTreeModel = new PublishTreeModel();
        this.checkboxTree = new PublishCheckboxTree(publishTreeModel);

        // Register tooltips
        checkboxTree.setToolTipText(""); //$NON-NLS-1$
        TreeCheckingModel checkingModel = publishTreeModel.getCheckingModel();
        checkboxTree.setCheckingModel(checkingModel); // be aware that checkingPaths is cleared at this point

        setViewportView(checkboxTree);
    }

    public CheckboxTree getTree() {
        return checkboxTree;
    }

    public PublishTreeModel getModel() {
        return publishTreeModel;
    }

    public void addTreeCheckingListener(TreeCheckingListener tsl) {
        checkboxTree.addTreeCheckingListener(tsl);
    }
}