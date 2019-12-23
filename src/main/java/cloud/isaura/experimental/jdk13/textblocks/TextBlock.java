package cloud.isaura.experimental.jdk13.textblocks;

public class TextBlock {



    public static String getQuery(){
        String query =
                        """
                        select *
                        from dummy
                        where dummy.field = """+12+"""
                        """;
        return query;
    }


}
