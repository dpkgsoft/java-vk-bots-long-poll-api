package api.longpoll.bots.methods.impl.board;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;

/**
 * Implements <b>board.deleteComment</b> method.
 * <p>
 * Deletes a comment on a topic on a community's discussion board.
 *
 * @see <a href="https://vk.com/dev/board.deleteComment">https://vk.com/dev/board.deleteComment</a>
 */
public class DeleteComment extends VkMethod<IntegerResponseBody> {
    public DeleteComment(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return property("board.deleteComment");
    }

    @Override
    protected Class<IntegerResponseBody> getResponseClass() {
        return IntegerResponseBody.class;
    }

    /**
     * Sets Group ID.
     *
     * @param groupId Group ID.
     * @return this instance.
     */
    public DeleteComment setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    /**
     * Sets Topic ID.
     *
     * @param topicId Topic ID.
     * @return this instance.
     */
    public DeleteComment setTopicId(int topicId) {
        return addParam("topic_id", topicId);
    }

    /**
     * Sets Comment ID.
     *
     * @param commentId Comment ID.
     * @return this instance.
     */
    public DeleteComment setCommentId(int commentId) {
        return addParam("comment_id", commentId);
    }

    @Override
    public DeleteComment addParam(String key, Object value) {
        return (DeleteComment) super.addParam(key, value);
    }
}
