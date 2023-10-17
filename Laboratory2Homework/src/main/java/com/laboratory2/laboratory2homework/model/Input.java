package com.laboratory2.laboratory2homework.model;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

/**
 * Input model.
 */
public class Input {
    private Part graphFile;

    public Part getGraphFile() {
        return graphFile;
    }

    public void setGraphFile(Part graphFile) {
        this.graphFile = graphFile;
    }

    public InputStream getGraphFileInputStream() throws IOException {
        return graphFile.getInputStream();
    }
}
