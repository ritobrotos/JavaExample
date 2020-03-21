package genericConcept;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 23/12/16.
 */
public class GenericWildcardExample {

  public static void main(String args[]){
    GenericWildcardExample mainObj = new GenericWildcardExample();
    mainObj.testListGenerics();
//    mainObj.methodOne(new ChildAC());
  }

  private void methodOne(Class<? extends ParentC> obj) {

  }

  private void testListGenerics() {
    List<ParentC> parentList = new ArrayList<ParentC>();
    parentList.add(new ParentC());
    parentList.add(new ParentC());
    parentList.add(new ParentC());
    System.out.println(parentList.size());

    List<? extends ParentC> subList = new ArrayList<ParentC>();
//    subList.add(new ChildAC());
    subList = parentList;

//    List<ParentC> typeParentList = new ArrayList<ChildAC>();
//    List<ChildAC> tyList = new ArrayList<ParentC>();
  }

}

class ParentC { int val = 1; }

class ChildAC extends ParentC { }

class childBC extends ParentC { }
