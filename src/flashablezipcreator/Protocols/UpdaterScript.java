/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Protocols;

import flashablezipcreator.Core.GroupNode;
import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.Core.ProjectNode;
import flashablezipcreator.Operations.TreeOperations;
import flashablezipcreator.Operations.UpdaterScriptOperations;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Nikhil
 */
public class UpdaterScript {

    public static String updaterScript = "";
    public static TreeOperations to;
    public static UpdaterScriptOperations op = new UpdaterScriptOperations();
    public static String updaterScriptPath = "META-INF/com/google/android/updater-script";
    public static String symlinkScriptPath = "META-INF/com/google/android/symlink-script";
    public static String symlinkScript = op.getSymlinkScript();

    public static String build(ProjectItemNode rootNode) throws FileNotFoundException, IOException {
        updaterScript = "";
        to = new TreeOperations();
        updaterScript += op.initiateUpdaterScript();
        for (ProjectItemNode project : to.getProjectsSorted(rootNode)) {
            if (((ProjectNode) project).prop.createZip) {
                switch (((ProjectNode) project).prop.projectType) {
                    case Types.PROJECT_AROMA:
                    case Types.PROJECT_CUSTOM:
                    case Types.PROJECT_MOD:
                        updaterScript += buildAromaScript((ProjectNode) project);
                        break;
                }
            }
        }
        updaterScript += op.addWipeDalvikCacheString();
        updaterScript += op.addPrintString("@Finished Install");
        return updaterScript;
    }

    public static String buildNormalScript(ProjectNode project) {
        String str = "";
        return str;
    }

    public static String buildAromaScript(ProjectNode project) {
        String str = "";
        str += "if (file_getprop(\"/tmp/aroma/" + project.prop.title + ".prop\", \"selected\")==\"1\") then\n";
        str += op.getMountMethod(1);
        //str += op.getExtractDataString();
        str += "set_progress(0);\n";
        for (ProjectItemNode group : to.getNodeList(Types.NODE_GROUP)) {
            if (((ProjectNode) group.prop.parent).prop.projectType == project.prop.projectType && ((ProjectNode) group.prop.parent).prop.title.equals(project.prop.title)) {
                str += op.generateUpdaterScript((GroupNode) group);
            }
        }
        str += "set_progress(1);\n";
        //str += op.terminateUpdaterScript();//unmounting is not needed
        return str += "endif;\n";
    }

    public static String getDpiScript(String dpi) {
        return op.getDpiScript(dpi);
    }
}
