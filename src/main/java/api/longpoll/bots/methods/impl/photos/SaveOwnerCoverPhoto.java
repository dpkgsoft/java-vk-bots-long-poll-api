package api.longpoll.bots.methods.impl.photos;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.additional.Image;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Implements <b>photos.saveOwnerCoverPhoto</b> method.
 * <p>
 * Saves cover photo after successful uploading.
 *
 * @see <a href="https://vk.com/dev/photos.saveOwnerCoverPhoto">https://vk.com/dev/photos.saveOwnerCoverPhoto</a>
 */
public class SaveOwnerCoverPhoto extends VkMethod<SaveOwnerCoverPhoto.ResponseBody> {
    public SaveOwnerCoverPhoto(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return property("photos.saveOwnerCoverPhoto");
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public SaveOwnerCoverPhoto setHash(String hash) {
        return addParam("hash", hash);
    }

    public SaveOwnerCoverPhoto setPhoto(String photo) {
        return addParam("photo", photo);
    }

    @Override
    public SaveOwnerCoverPhoto addParam(String key, Object value) {
        return (SaveOwnerCoverPhoto) super.addParam(key, value);
    }

    /**
     * Response to <b>photos.saveOwnerCoverPhoto</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<ResponseBody.Response> {
        /**
         * Response object.
         */
        public static class Response {
            /**
             * List of photo copies.
             */
            @SerializedName("images")
            private List<Image> images;

            public List<Image> getImages() {
                return images;
            }

            public void setImages(List<Image> images) {
                this.images = images;
            }

            @Override
            public String toString() {
                return "Response{" +
                        "images=" + images +
                        '}';
            }
        }
    }
}
