package api.longpoll.bots.methods.impl.wall;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.additional.UploadedFile;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>wall.createComment</b> method.
 * <p>
 * Adds a comment to a post on a user wall or community wall.
 *
 * @see <a href="https://vk.com/dev/wall.createComment">https://vk.com/dev/wall.createComment</a>
 */
public class CreateComment extends VkMethod<CreateComment.ResponseBody> {

    public CreateComment(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return VK_METHODS.getProperty("wall.createComment");
    }

    @Override
    protected Class<ResponseBody> getResponseType() {
        return ResponseBody.class;
    }

    public CreateComment setAttachment(UploadedFile... attachments) {
        return setAttachment(Arrays.asList(attachments));
    }

    public CreateComment setAttachment(List<UploadedFile> attachments) {
        return setAttachment(csv(attachments));
    }

    public CreateComment setAttachment(String attachment) {
        return addParam("attachment", attachment);
    }

    public CreateComment setOwnerId(int ownerId) {
        return addParam("owner_id", ownerId);
    }

    public CreateComment setPostId(int postId) {
        return addParam("post_id", postId);
    }

    public CreateComment setFromGroupId(int fromGroupId) {
        return addParam("from_group", fromGroupId);
    }

    public CreateComment setMessage(String message) {
        return addParam("message", message);
    }

    public CreateComment setReplyToComment(int replyToComment) {
        return addParam("reply_to_comment", replyToComment);
    }

    public CreateComment setStickerId(int stickerId) {
        return addParam("sticker_id", stickerId);
    }

    public CreateComment setGuid(String guid) {
        return addParam("guid", guid);
    }

    @Override
    public CreateComment addParam(String key, Object value) {
        return (CreateComment) super.addParam(key, value);
    }

    /**
     * Response to <b>wall.createComment</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<ResponseBody.Response> {
        /**
         * Response object.
         */
        public static class Response {
            /**
             * Added comment ID.
             */
            @SerializedName("comment_id")
            private Integer commentId;

            /**
             * List of parent comments.
             */
            @SerializedName("parent_stack")
            private List<Integer> parentStack;

            public Integer getCommentId() {
                return commentId;
            }

            public void setCommentId(Integer commentId) {
                this.commentId = commentId;
            }

            public List<Integer> getParentStack() {
                return parentStack;
            }

            public void setParentStack(List<Integer> parentStack) {
                this.parentStack = parentStack;
            }

            @Override
            public String toString() {
                return "Response{" +
                        "commentId=" + commentId +
                        ", parentStack=" + parentStack +
                        '}';
            }
        }
    }
}
