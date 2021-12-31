package App.Algorithms;

        import App.Usecases.Node;
        import App.Data.Student;
        import App.Lists.SingleLinkedList;
        import App.enums.SearchOptions;

public class SearchTool {

    protected static long compares = 0;
    protected static long loops = 0;

    public static SingleLinkedList<Student> search(SingleLinkedList<Student> list, SearchOptions option, String query) {


        compares = 0;
        loops = 0;

        SingleLinkedList<Student> result = new SingleLinkedList<>();

        Node<Student> tmp = list.getHead();

        while (tmp != null) {

            loops++;
            compares++;

            switch (option) {

                case Matrikelnumber:
                    if (String.valueOf(tmp.getData().getMatrikelnr()).equals(query))
                        result.add(tmp.getData());
                    break;

                case Prename:
                    if ((tmp.getData().getFirstName()).equalsIgnoreCase(query))
                        result.add(tmp.getData());
                    break;

                case Lastname:
                    if ((tmp.getData().getLastName()).equalsIgnoreCase(query))
                        result.add(tmp.getData());
                    break;

                case Studies:
                    if (String.valueOf(tmp.getData().getStudies()).equals(query))
                        result.add(tmp.getData());
                    break;
            }

            tmp = tmp.getNext();
        }


        System.out.println(result);
        return result;
    }

}

