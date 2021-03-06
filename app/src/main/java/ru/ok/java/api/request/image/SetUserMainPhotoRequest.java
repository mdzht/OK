package ru.ok.java.api.request.image;

import ru.ok.java.api.request.BaseRequest;
import ru.ok.java.api.request.serializer.RequestSerializer;
import ru.ok.java.api.request.serializer.SerializeParamName;
import ru.ok.java.api.request.serializer.http.HttpPreamble;

@HttpPreamble(hasSessionKey = true)
public class SetUserMainPhotoRequest extends BaseRequest {
    private final String pid;

    public SetUserMainPhotoRequest(String pid) {
        this.pid = pid;
    }

    public String getMethodName() {
        return "users.setMainPhoto";
    }

    public void serializeInternal(RequestSerializer<?> serializer) {
        serializer.add(SerializeParamName.PHOTO_ID, this.pid);
    }
}
