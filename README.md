## Micronaut 2.3.2 Documentation

- [User Guide](https://docs.micronaut.io/2.3.2/guide/index.html)
- [API Reference](https://docs.micronaut.io/2.3.2/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/2.3.2/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Para executar o nats streaming no docker

docker run -d --name=nats-stream -p 4222:4222 -p 6222:6222 -p 8222:8222 -v /path_onde_sera_armazenado_os_dados:/datastore nats-streaming --user user --pass password -store file -dir datastore