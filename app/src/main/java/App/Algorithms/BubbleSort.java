package App.Algorithms;

import App.Lists.IListable;

public class BubbleSort<T> extends App.Algorithms.Swap<T> implements App.Algorithms.Sortable<T> {

    @Override
    public void sort(IListable<T> list, Comparator<T> comp) {
        int n = list.size();
        for (int i = 0 ; i < n-1 ; i++){
            for (int j = 0; j < n-i-1 ; j++){
                if(comp.compare(list.get(j), list.get(j+1)) > 0){
                    T temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1 , temp);
                }
            }
        }
    }
}