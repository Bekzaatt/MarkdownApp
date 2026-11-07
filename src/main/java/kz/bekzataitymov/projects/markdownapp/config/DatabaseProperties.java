package kz.bekzataitymov.projects.markdownapp.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatabaseProperties {
    private String driver;
    private String url;
    private String username;
    private String password;
}
