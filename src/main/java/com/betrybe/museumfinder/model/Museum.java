package com.betrybe.museumfinder.model;

/**
 * Esta classe representa um museu. Contém informações sobre o museu, como nome, descrição,
 * endereço, tipo de coleção, assunto, URL, coordenada e ID legado.
 */
public class Museum {

  private Long id;
  private String name;
  private String description;
  private String address;
  private String collectionType;
  private String subject;
  private String url;
  private Coordinate coordinate;
  private Long legacyId;

  /**
   * Construtor padrão da classe Museum. Inicializa um objeto Museum vazio.
   */
  public Museum() {
  }

  /**
   * Obtém o ID do museu.
   *
   * @return O ID do museu.
   */
  public Long getId() {
    return id;
  }

  /**
   * Define o ID do museu.
   *
   * @param id O ID do museu a ser definido.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Obtém o nome do museu.
   *
   * @return O nome do museu.
   */
  public String getName() {
    return name;
  }

  /**
   * Define o nome do museu.
   *
   * @param name O nome do museu a ser definido.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Obtém a descrição do museu.
   *
   * @return A descrição do museu.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Define a descrição do museu.
   *
   * @param description A descrição do museu a ser definida.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Obtém o endereço do museu.
   *
   * @return O endereço do museu.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Define o endereço do museu.
   *
   * @param address O endereço do museu a ser definido.
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Obtém o tipo de coleção do museu.
   *
   * @return O tipo de coleção do museu.
   */
  public String getCollectionType() {
    return collectionType;
  }

  /**
   * Define o tipo de coleção do museu.
   *
   * @param collectionType O tipo de coleção do museu a ser definido.
   */
  public void setCollectionType(String collectionType) {
    this.collectionType = collectionType;
  }

  /**
   * Obtém o assunto do museu.
   *
   * @return O assunto do museu.
   */
  public String getSubject() {
    return subject;
  }

  /**
   * Define o assunto do museu.
   *
   * @param subject O assunto do museu a ser definido.
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * Obtém a URL do museu.
   *
   * @return A URL do museu.
   */
  public String getUrl() {
    return url;
  }

  /**
   * Define a URL do museu.
   *
   * @param url A URL do museu a ser definida.
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Obtém as coordenadas do museu.
   *
   * @return As coordenadas do museu.
   */
  public Coordinate getCoordinate() {
    return coordinate;
  }

  /**
   * Define as coordenadas do museu.
   *
   * @param coordinate As coordenadas do museu a serem definidas.
   */
  public void setCoordinate(Coordinate coordinate) {
    this.coordinate = coordinate;
  }

  /**
   * Obtém o ID legado do museu.
   *
   * @return O ID legado do museu.
   */
  public Long getLegacyId() {
    return legacyId;
  }

  /**
   * Define o ID legado do museu.
   *
   * @param legacyId O ID legado do museu a ser definido.
   */
  public void setLegacyId(Long legacyId) {
    this.legacyId = legacyId;
  }
}
