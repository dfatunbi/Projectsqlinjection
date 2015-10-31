#
# Elasticsearch Dockerfile
#
# https://github.com/dockerfile/elasticsearch
#

# Pull base image.
FROM java

ENV ES_PKG_NAME elasticsearch-1.5.0
ENV MARVEL_PKG_NAME marvel-latest
ENV KOPF_PKG_NAME elasticsearch-kopf-master
ENV HEAD_PKG_NAME elasticsearch-head-master
ENV BIGDESK_PKG_NAME bigdesk-master

# Install Elasticsearch.
COPY ./soft/* /


RUN \
  cd / && \
  tar xvzf $ES_PKG_NAME.tar.gz && \
  rm -f $ES_PKG_NAME.tar.gz && \
  mv /$ES_PKG_NAME /elasticsearch

# Define mountable directories.
VOLUME ["/data"]

# Mount elasticsearch.yml config
ADD config/elasticsearch.yml /elasticsearch/config/elasticsearch.yml

# Install marvel plugin
RUN \
  cd / && \
  mkdir -p /plugins/marvel/ && \
  mv $MARVEL_PKG_NAME.zip /plugins/marvel/ && \
  cd /plugins/marvel/ && \
  unzip $MARVEL_PKG_NAME.zip && \
  rm $MARVEL_PKG_NAME.zip
  
RUN \
  cd / && \
  mkdir -p /plugins/kopf/ && \
  unzip $KOPF_PKG_NAME.zip && \
  mv $KOPF_PKG_NAME /plugins/kopf/_site && \
  rm $KOPF_PKG_NAME.zip

# Install elasticsearch head plugin
RUN \
  cd / && \
  mkdir -p /plugins/head && \
  unzip $HEAD_PKG_NAME.zip && \
  mv $HEAD_PKG_NAME /plugins/head/_site && \
  rm $HEAD_PKG_NAME.zip

# Install bigdesk plugin
RUN \
  cd / && \
  mkdir -p /plugins/bigdesk && \
  unzip $BIGDESK_PKG_NAME.zip && \
  mv $BIGDESK_PKG_NAME /plugins/bigdesk/_site && \
  rm $BIGDESK_PKG_NAME.zip

# Define working directory.
WORKDIR /data

# Define default command.
CMD ["/elasticsearch/bin/elasticsearch"]

# Expose ports.
#   - 9200: HTTP
#   - 9300: transport
EXPOSE 9200
EXPOSE 9300