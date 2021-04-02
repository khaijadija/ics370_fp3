

	public final class Theater {
	    private static Theater instance;
	    public String value;

	    private Theater(String value) {
	        // The following code emulates slow initialization.
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException ex) {
	            ex.printStackTrace();
	        }
	        this.value = value;
	    }

	    public static Theater getInstance(String value) {
	        if (instance == null) {
	            instance = new Theater(value);
	        }
	        return instance;
	    }
	}

