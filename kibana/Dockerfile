# Pull base image.
FROM debian

ENV KIBANA_VERSION kibana-4.0.2-linux-x64

COPY kibana-4.0.2-linux-x64.tar.gz /tmp/kibana-4.0.2-linux-x64.tar.gz

# Install KIBANA.
RUN \
  cd /tmp && \
  gzip -d ${KIBANA_VERSION}.tar.gz && \
  tar xvf ${KIBANA_VERSION}.tar && \
  rm -f ${KIBANA_VERSION}.tar* && \
  mv /tmp/${KIBANA_VERSION} /kibana

ADD start.sh /start.sh
RUN chmod +x /start.sh && mkdir log

# Define default command.
CMD ["/start.sh"]

# Expose ports.
EXPOSE 5601
