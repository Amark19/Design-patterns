package net.media.training.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 19, 2011
 * Time: 9:18:51 PM
 * To change this template use pre_refactoring.File | Settings |
 * pre_refactoring.File Templates.
 */
public class Directory implements FileSystem {
    private String name;
    private List<FileSystem> contents = new ArrayList<>();
    private Directory parent;

    public String getName() {
        return name;
    }

    public Directory(String name, List<FileSystem> contents) {
        this.name = name;
        this.contents = contents;
    }

    public int getSize() {

        int sum = 0;
        for (FileSystem content : contents) {
            sum += content.getSize();
        }

        return sum;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public void delete() {
        if (contents instanceof Directory) {
            while (contents.size() > 0) {
                FileSystem content = contents.get(0);
                if (content.size() > 0) {
                    content.delete();
                }
            }
            contents.remove(this);
        } else if (contents instanceof File) {
            contents.remove(this);
        }

        // if (parent != null) {
        //     parent.contents.remove(this);
        // }
    }
//             f0
//         f1        f2
//     f3      f4
// file2   

    public void add(FileSystem content) {
        contents.add(content);
    }

    public boolean exists(String name) {
        for (FileSystem content : contents) {
            if (content instanceof File && content.exists(name)) {
                return true;
            } else if (content instanceof Directory && content.exists(name)) {
                return true;
            }
        }

        return false;
    }

    public List<FileSystem> getcontents() {
        return contents;
    }

    public Directory getParent() {
        return parent;
    }

}