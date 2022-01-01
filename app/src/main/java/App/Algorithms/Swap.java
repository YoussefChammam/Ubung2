package App.Algorithms;

import App.Lists.IListable;

public class Swap<T> {
    protected void swap(IListable<T> list, int i, int j){
        T memorizedObject = list.get(i);
        list.set(i, list.get(j));
        list.set(j, memorizedObject);
    }
}
