package org.romanbielyi.geometry.exceptions;

import org.romanbielyi.geometry.exceptions.abstracts.VertexCountException;

public class TriangleVertexCountException extends VertexCountException {
    public TriangleVertexCountException(String msg) {
        super(msg);
    }
}
