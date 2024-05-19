import 'package:cached_network_image/cached_network_image.dart';
import 'package:carousel_slider/carousel_slider.dart';
import 'package:flutter/material.dart';
import 'package:flutter_staggered_grid_view/flutter_staggered_grid_view.dart';
import 'package:kulturruhr/models/post_content_model.dart';
import 'package:kulturruhr/models/post_model.dart';
import 'package:kulturruhr/utils/constants/custom_fonts.dart';
import 'package:kulturruhr/utils/device_size.dart';

class FeedBox extends StatelessWidget {
  final Post post;
  const FeedBox({super.key, required this.post});

  TextSpan createStyledTextSpan({
    required String self,
    required List<String> mentions,
  }) {
    // Define styles
    final TextStyle selfStyle = TextStyle(
        fontWeight: FontWeight.bold,
        color: Colors.black,
        fontSize: 11.5,
        fontFamily: CustomFont.poppins);
    final TextStyle mentionStyle = TextStyle(
        fontWeight: FontWeight.bold,
        color: Colors.black,
        fontSize: 11.5,
        fontFamily: CustomFont.poppins);
    final TextStyle normalStyle = TextStyle(
        color: Colors.black45, fontSize: 11.5, fontFamily: CustomFont.poppins);

    // Build the text span
    return TextSpan(
      children: [
        TextSpan(text: self, style: selfStyle),
        TextSpan(text: ' is with ', style: normalStyle),
        ...mentions.map((mention) => TextSpan(
              text: mention,
              style: mentionStyle,
              children: [TextSpan(text: '', style: normalStyle)],
            )),
      ],
    );
  }

  Widget decideMediaBox(double height) {
    List<PostContent> posts = post.postList;
    // If number of media files is 0
    if (posts.isEmpty) {
      return const SizedBox();
    } // If number of media files is 1
    else if (posts.length == 1) {
      if (posts.first.type == "image") {
        return ClipRRect(
            borderRadius: BorderRadius.circular(15),
            child: CachedNetworkImage(
                imageUrl: posts.first.url, fit: BoxFit.cover));
      } else {
        // TODO : Handle video files
        return const SizedBox();
      }
    } // If number of media files is 2
    else if (posts.length == 2) {
      return CarouselSlider(
          items: posts.map((pc) {
            if (pc.type == 'image') {
              return ClipRRect(
                borderRadius: BorderRadius.circular(15),
                child: CachedNetworkImage(
                  imageUrl: pc.url,
                  fit: BoxFit.cover,
                ),
              );
            } else {
              // TODO : Render video
              return const SizedBox();
            }
          }).toList(),
          options: CarouselOptions(
            height: height,
            aspectRatio: 16 / 9,
            viewportFraction: 0.85,
            initialPage: 0,
            enableInfiniteScroll: true,
            reverse: false,
            autoPlay: true,
            pauseAutoPlayOnManualNavigate: true,
            autoPlayAnimationDuration: const Duration(milliseconds: 800),
            autoPlayCurve: Curves.fastOutSlowIn,
            enlargeCenterPage: true,
            enlargeFactor: 0.3,
            onPageChanged: (index, reason) {},
            scrollDirection: Axis.horizontal,
          ));
    }
    // If number of media files is 3
    else if (posts.length == 3) {
      return StaggeredGrid.count(
        crossAxisCount: 2,
        mainAxisSpacing: 5,
        crossAxisSpacing: 4,
        children: [
          StaggeredGridTile.count(
            crossAxisCellCount: 3,
            mainAxisCellCount: 1.2,
            child: (posts[0].type == 'image')
                ? ClipRRect(
                    borderRadius: BorderRadius.circular(15),
                    child: CachedNetworkImage(
                      imageUrl: posts[0].url,
                      fit: BoxFit.cover,
                    ),
                  )
                : const SizedBox(), // TODO : Video player
          ),
          StaggeredGridTile.count(
            crossAxisCellCount: 1,
            mainAxisCellCount: 1.2,
            child: (posts[1].type == 'image')
                ? ClipRRect(
                    borderRadius: BorderRadius.circular(15),
                    child: CachedNetworkImage(
                      imageUrl: posts[1].url,
                      fit: BoxFit.cover,
                    ),
                  )
                : const SizedBox(), // TODO : Video player,
          ),
          StaggeredGridTile.count(
            crossAxisCellCount: 1,
            mainAxisCellCount: 1.2,
            child: (posts[2].type == 'image')
                ? ClipRRect(
                    borderRadius: BorderRadius.circular(15),
                    child: CachedNetworkImage(
                      imageUrl: posts[2].url,
                      fit: BoxFit.cover,
                    ),
                  )
                : const SizedBox(), // TODO : Video player ,
          ),
        ],
      );
    }
    // If number of media files is 4
    else if (posts.length == 4) {
      return StaggeredGrid.count(
        crossAxisCount: 4,
        mainAxisSpacing: 5,
        crossAxisSpacing: 4,
        children: [
          StaggeredGridTile.count(
            crossAxisCellCount: 2,
            mainAxisCellCount: 2,
            child: (posts[0].type == 'image')
                ? ClipRRect(
                    borderRadius: BorderRadius.circular(15),
                    child: CachedNetworkImage(
                      imageUrl: posts[0].url,
                      fit: BoxFit.cover,
                    ),
                  )
                : const SizedBox(), // TODO : Video player
          ),
          StaggeredGridTile.count(
            crossAxisCellCount: 2,
            mainAxisCellCount: 2,
            child: (posts[1].type == 'image')
                ? ClipRRect(
                    borderRadius: BorderRadius.circular(15),
                    child: CachedNetworkImage(
                      imageUrl: posts[1].url,
                      fit: BoxFit.cover,
                    ),
                  )
                : const SizedBox(), // TODO : Video player,
          ),
          StaggeredGridTile.count(
            crossAxisCellCount: 2,
            mainAxisCellCount: 2,
            child: (posts[2].type == 'image')
                ? ClipRRect(
                    borderRadius: BorderRadius.circular(15),
                    child: CachedNetworkImage(
                      imageUrl: posts[2].url,
                      fit: BoxFit.cover,
                    ),
                  )
                : const SizedBox(), // TODO : Video player ,
          ),
          StaggeredGridTile.count(
            crossAxisCellCount: 2,
            mainAxisCellCount: 2,
            child: (posts[3].type == 'image')
                ? ClipRRect(
                    borderRadius: BorderRadius.circular(15),
                    child: CachedNetworkImage(
                      imageUrl: posts[3].url,
                      fit: BoxFit.cover,
                    ),
                  )
                : const SizedBox(), // TODO : Video player ,
          ),
        ],
      );
    }
    // If number of media files is 5
    else if (posts.length == 5) {
      return StaggeredGrid.count(
        crossAxisCount: 4,
        mainAxisSpacing: 4,
        crossAxisSpacing: 4,
        children: [
          StaggeredGridTile.count(
            crossAxisCellCount: 2,
            mainAxisCellCount: 2.1,
            child: (posts[0].type == 'image')
                ? ClipRRect(
                    borderRadius: BorderRadius.circular(15),
                    child: CachedNetworkImage(
                      imageUrl: posts[0].url,
                      fit: BoxFit.cover,
                    ),
                  )
                : const SizedBox(), // TODO : Video player ,,
          ),
          StaggeredGridTile.count(
            crossAxisCellCount: 2,
            mainAxisCellCount: 1.2,
            child: (posts[1].type == 'image')
                ? ClipRRect(
                    borderRadius: BorderRadius.circular(15),
                    child: CachedNetworkImage(
                      imageUrl: posts[1].url,
                      fit: BoxFit.cover,
                    ),
                  )
                : const SizedBox(), // TODO : Video player ,,
          ),
          StaggeredGridTile.count(
            crossAxisCellCount: 1,
            mainAxisCellCount: 1,
            child: (posts[2].type == 'image')
                ? ClipRRect(
                    borderRadius: BorderRadius.circular(15),
                    child: CachedNetworkImage(
                      imageUrl: posts[2].url,
                      fit: BoxFit.cover,
                    ),
                  )
                : const SizedBox(), // TODO : Video player ,,
          ),
          StaggeredGridTile.count(
            crossAxisCellCount: 1,
            mainAxisCellCount: 1,
            child: (posts[3].type == 'image')
                ? ClipRRect(
                    borderRadius: BorderRadius.circular(15),
                    child: CachedNetworkImage(
                      imageUrl: posts[3].url,
                      fit: BoxFit.cover,
                    ),
                  )
                : const SizedBox(), // TODO : Video player ,,
          ),
          StaggeredGridTile.count(
            crossAxisCellCount: 4,
            mainAxisCellCount: 2,
            child: (posts[4].type == 'image')
                ? ClipRRect(
                    borderRadius: BorderRadius.circular(15),
                    child: CachedNetworkImage(
                      imageUrl: posts[4].url,
                      fit: BoxFit.cover,
                    ),
                  )
                : const SizedBox(), // TODO : Video player ,,
          ),
        ],
      );
    } else {
      return const SizedBox();
    }
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.white,
      width: double.infinity,
      padding: const EdgeInsets.only(left: 14, right: 14, top: 10, bottom: 10),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.start,
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.start,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              const CircleAvatar(
                radius: 20,
                backgroundImage: NetworkImage(
                    "https://i.pinimg.com/564x/98/af/c9/98afc975433a4341a6fc0934d960feef.jpg"),
              ),
              const SizedBox(
                width: 10,
              ),
              (post.mentions.isNotEmpty)
                  ? Expanded(
                      child: RichText(
                        maxLines: 2,
                        // softWrap: true,
                        overflow: TextOverflow.ellipsis,
                        text: createStyledTextSpan(
                            self: "Subhojeet Sahoo",
                            mentions: ["Aradhana Roy"]),
                      ),
                    )
                  : Text(
                      "Subhojeet Sahoo",
                      style: TextStyle(
                          fontWeight: FontWeight.bold,
                          color: Colors.black,
                          fontSize: 11.5,
                          fontFamily: CustomFont.poppins),
                    ),
            ],
          ),
          const SizedBox(height: 8),
          Text(
            post.caption,
            maxLines: 4,
            overflow: TextOverflow.ellipsis,
            style: TextStyle(fontSize: 12, fontFamily: CustomFont.poppins),
          ),
          const SizedBox(
            height: 8,
          ),
          decideMediaBox(displayHeight(context) * 0.47)
        ],
      ),
    );
  }
}