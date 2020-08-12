package parse.response.video;

import api.longpoll.bots.converters.updates.UpdateResponseConverterImpl;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.response.events.GetEventsResult;
import api.longpoll.bots.model.video.VideoCommentDeleteEvent;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VideoCommentDeleteParseTest extends AbstractParseTest {
	@Test
	public void test1_videoCommentDelete() throws IOException {
		JsonObject jsonObject = readJson("json/response/video_comment_delete/video_comment_delete_sample_5_110.json");
		GetEventsResult getEventsResult = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(getEventsResult);
		Assert.assertEquals(Integer.valueOf(2622), getEventsResult.getTs());

		List<Event> events = getEventsResult.getEvents();
		Assert.assertNotNull(events);
		Assert.assertEquals(1, events.size());

		Event event = events.get(0);
		Assert.assertNotNull(event);
		Assert.assertEquals("video_comment_delete", event.getType());
		Assert.assertEquals(Integer.valueOf(168975658), event.getGroupId());
		Assert.assertEquals("c790943c674f5cd91396f351cbc0aa60285e3c86", event.getEventId());

		EventObject eventObject = event.getObject();
		Assert.assertNotNull(eventObject);

		Assert.assertTrue(eventObject instanceof VideoCommentDeleteEvent);
		VideoCommentDeleteEvent videoCommentDeleteUpdate = (VideoCommentDeleteEvent) eventObject;
		Assert.assertEquals(Integer.valueOf(1), videoCommentDeleteUpdate.getId());
		Assert.assertEquals(Integer.valueOf(-168975658), videoCommentDeleteUpdate.getOwnerId());
		Assert.assertEquals(Integer.valueOf(381980625), videoCommentDeleteUpdate.getDeleterId());
		Assert.assertEquals(Integer.valueOf(456239017), videoCommentDeleteUpdate.getVideoId());
	}
}
