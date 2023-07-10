package com.github.topi314.lavasrc.plugin;

import com.github.topi314.lavasrc.ExtendedAudioPlaylist;
import com.github.topi314.lavasrc.ExtendedAudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import dev.arbjerg.lavalink.api.AudioPluginInfoModifier;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LavaSrcAudioPluginInfoModifier implements AudioPluginInfoModifier {

	@Override
	public JsonObject modifyAudioPlaylistPluginInfo(@NotNull AudioPlaylist playlist) {
		if (playlist instanceof ExtendedAudioPlaylist extendedPlaylist) {
			return new JsonObject(Map.of(
				"type", JsonElementKt.JsonPrimitive(extendedPlaylist.getType()),
				"url", JsonElementKt.JsonPrimitive(extendedPlaylist.getUrl()),
				"artworkUrl", JsonElementKt.JsonPrimitive(extendedPlaylist.getArtworkURL()),
				"author", JsonElementKt.JsonPrimitive(extendedPlaylist.getAuthor())
			));
		}
		return null;
	}

	@Nullable
	@Override
	public JsonObject modifyAudioTrackPluginInfo(@NotNull AudioTrack track) {
		if (track instanceof ExtendedAudioTrack extendedTrack) {
			return new JsonObject(Map.of(
				"albumName", JsonElementKt.JsonPrimitive(extendedTrack.getAlbumName()),
				"artistArtworkUrl", JsonElementKt.JsonPrimitive(extendedTrack.getArtistArtworkUrl()),
				"previewUrl", JsonElementKt.JsonPrimitive(extendedTrack.getPreviewUrl())
			));
		}
		return null;
	}
}