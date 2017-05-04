package de.hsa.games.fastsquirrel.util.ui.consoletest;

public enum MyFavoriteCommandType implements CommandTypeInfo {
    HELP("help", "  * list all commands") {
        @Override
        public String getName() {
            return "help";
        }

        @Override
        public String getHelpText() {
            return "  * list all commands";
        }

        @Override
        public Class<?>[] getParamTypes() {
            return null;
        }
    },
    EXIT("exit", "  * exit program") {
        @Override
        public String getName() {
            return "exit";
        }

        @Override
        public String getHelpText() {
            return "  * exit program";
        }

        @Override
        public Class<?>[] getParamTypes() {
            return null;
        }
    },
    ADDI("addi", "<param1>  <param2>   * simple integer add ", int.class, int.class) {
        @Override
        public String getName() {
            return "addi";
        }

        @Override
        public String getHelpText() {
            return "<param1>  <param2>   * simple integer add ";
        }

        @Override
        public Class<?>[] getParamTypes() {
            Class<?>[] type = new Class<?>[2];
            type[0] = int.class;
            type[1] = int.class;
            return type;
        }
    },
    ADDF("addf", "<param1>  <param2>   * simple float add ", float.class, float.class) {
        @Override
        public String getName() {
            return "addf";
        }

        @Override
        public String getHelpText() {
            return "<param1>  <param2>   * simple float add ";
        }

        @Override
        public Class<?>[] getParamTypes() {
            Class<?>[] type = new Class<?>[2];
            type[0] = float.class;
            type[1] = float.class;
            return type;
        }
    },
    ECHO("echo", "<param1>  <param2>   * echos param1 string param2 times ", String.class, int.class) {
        @Override
        public String getName() {
            return "echo";
        }

        @Override
        public String getHelpText() {
            return "<param1>  <param2>   * echos param1 string param2 times ";
        }

        @Override
        public Class<?>[] getParamTypes() {
            Class<?>[] type = new Class<?>[2];
            type[0] = String.class;
            type[1] = int.class;
            return type;
        }
    };


    private final String commandType;
    private final String commandExplanation;
    private final Class inputType1;
    private final Class inputType2;

   MyFavoriteCommandType(String command, String explanation) {
        this.commandType = command;
        this.commandExplanation = explanation;
        inputType1 = null;
        inputType2 = null;
    }

    MyFavoriteCommandType(String command, String s, Class type1, Class type2) {
        this.commandType = command;
        this.commandExplanation = s;
        this.inputType1 = type1;
        this.inputType2 = type2;
    }





    public String getCommandType() {
        return commandType;
    }

    public String getCommandExplanation() {
        return commandExplanation;
    }

    public Class getInputType1() {
        return inputType1;
    }

    public Class getInputType2() {
        return inputType2;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
