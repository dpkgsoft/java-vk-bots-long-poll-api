package api.longpoll.bots.methods.impl.wall;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;

/**
 * Implements <b>wall.openComments</b> method.
 *
 * @see <a href="https://vk.com/dev/wall.openComments">https://vk.com/dev/wall.openComments</a>
 */
public class OpenComments extends VkMethod<IntegerResponseBody> {
    public OpenComments(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return property("wall.openComments");
    }

    @Override
    protected Class<IntegerResponseBody> getResponseClass() {
        return IntegerResponseBody.class;
    }

    public OpenComments setOwnerId(int ownerId) {
        return addParam("owner_id", ownerId);
    }

    public OpenComments setPostId(int postId) {
        return addParam("post_id", postId);
    }

    @Override
    public OpenComments addParam(String key, Object value) {
        return (OpenComments) super.addParam(key, value);
    }
}
