<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>固定在网页底部的HTML5音乐播放器插件代码</title>
<link rel="stylesheet" type="text/css" href="/Godvoice/css/audio.css">
</head>
<body style="height: 999px">
	<div class="audio-box">
		<div class="audio-container">
			<div class="audio-view">
				<div class="audio-cover" ></div>
				<div class="audio-body">
					<h3 class="audio-title">未知歌曲</h3>
					<div class="audio-backs">
						<div class="audio-this-time">00:00</div>
						<div class="audio-count-time">00:00</div>
						<div class="audio-setbacks">
							<i class="audio-this-setbacks">
								<span class="audio-backs-btn"></span>
							</i>
							<span class="audio-cache-setbacks">
							</span>
						</div>
					</div>
				</div>
				<div class="audio-btn">
					<div class="audio-select">
						<div class="audio-prev"></div>
						<div class="audio-play"></div>
						<div class="audio-next"></div>
						<div class="audio-menu"></div>
						<div class="audio-volume"></div>
					</div>
					<div class="audio-set-volume">
						<div class="volume-box">
							<i><span></span></i>
						</div>
					</div>
					<div class="audio-list">
						<div class="audio-list-head">
							<p>歌单</p>
							<span class="menu-close">关闭</span>
						</div>
						<ul class="audio-inline">
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/audio.js"></script>
<script type="text/javascript">

$(function(){

	/*
	var song = [
		
		{
			'cover' : 'album/adele-liveat.jpg',
			'src' : 'song/Adele-RollingIntheDeep.mp3',
			'title' : 'Rolling In the Deep'
		}
	];
	*/

	audioFn = audioPlay({
		autoPlay : false  //是否立即播放第一首，autoPlay为true且song为空，会alert文本提示并退出
	});
	
	var playlist = eval('${playlistJson}');
	if(playlist != null )
	for(var i = 0 ; i < playlist.length ; i ++)
	{
		audioFn.newSong({
			'cover' : playlist[i].cover,
			'src' : playlist[i].src,
			'title' : playlist[i].title
		},true);
	}
	/* 向歌单中添加新曲目，第二个参数true为新增后立即播放该曲目，false则不播放 */
	
	/*audioFn.newSong({
		'cover' : 'album/adele-liveat.jpg',
		'src' : 'song/Adele-RollingIntheDeep.mp3',
		'title' : 'Rolling In the Deep'
	},false);*/
	
	/* 暂停播放 */
	//audioFn.stopAudio();

	/* 开启播放 */
	//audioFn.playAudio();

	/* 选择歌单中索引为3的曲目(索引是从0开始的)，第二个参数true立即播放该曲目，false则不播放 */
	//audioFn.selectMenu(3,true);

	/* 查看歌单中的曲目 */
	//console.log(audioFn.song);

	/* 当前播放曲目的对象 */
	//console.log(audioFn.audio);
});

</script>
<!--  
<c:forEach items="${playlist }" var="songJson">
	<script type="text/javascript">
		audioFn = audioPlay({
			autoPlay : false  //是否立即播放第一首，autoPlay为true且song为空，会alert文本提示并退出
		});
		var cover = "${songJson.cover}";
		var src = "${songJson.src}";
		var title = "${songJson.title}";
		audioFn.newSong({
			'cover' : cover,
			'src' : src,
			'title' : title
		},false);
	</script>
</c:forEach>
-->
</html>
