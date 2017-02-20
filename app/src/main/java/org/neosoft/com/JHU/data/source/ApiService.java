package org.neosoft.com.JHU.data.source;

/**
 * Created by Neyomal on 2/14/2017.
 */
public class ApiService {
    private static ApiService ourInstance = new ApiService();

    public static ApiService getInstance() {
        return ourInstance;
    }

    private ApiService() {
    }
}
