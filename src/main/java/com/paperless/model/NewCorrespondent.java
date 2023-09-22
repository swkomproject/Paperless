package com.paperless.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Arrays;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * NewCorrespondent
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-21T13:46:14.444283Z[Etc/UTC]")
public class NewCorrespondent {

  private JsonNullable<String> name = JsonNullable.<String>undefined();

  private JsonNullable<String> match = JsonNullable.<String>undefined();

  private Long matchingAlgorithm;

  private Boolean isInsensitive;

  private Long documentCount;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime lastCorrespondence;

  public NewCorrespondent name(String name) {
    this.name = JsonNullable.of(name);
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public JsonNullable<String> getName() {
    return name;
  }

  public void setName(JsonNullable<String> name) {
    this.name = name;
  }

  public NewCorrespondent match(String match) {
    this.match = JsonNullable.of(match);
    return this;
  }

  /**
   * Get match
   * @return match
  */
  
  @Schema(name = "match", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("match")
  public JsonNullable<String> getMatch() {
    return match;
  }

  public void setMatch(JsonNullable<String> match) {
    this.match = match;
  }

  public NewCorrespondent matchingAlgorithm(Long matchingAlgorithm) {
    this.matchingAlgorithm = matchingAlgorithm;
    return this;
  }

  /**
   * Get matchingAlgorithm
   * @return matchingAlgorithm
  */
  
  @Schema(name = "matching_algorithm", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("matching_algorithm")
  public Long getMatchingAlgorithm() {
    return matchingAlgorithm;
  }

  public void setMatchingAlgorithm(Long matchingAlgorithm) {
    this.matchingAlgorithm = matchingAlgorithm;
  }

  public NewCorrespondent isInsensitive(Boolean isInsensitive) {
    this.isInsensitive = isInsensitive;
    return this;
  }

  /**
   * Get isInsensitive
   * @return isInsensitive
  */
  
  @Schema(name = "is_insensitive", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("is_insensitive")
  public Boolean getIsInsensitive() {
    return isInsensitive;
  }

  public void setIsInsensitive(Boolean isInsensitive) {
    this.isInsensitive = isInsensitive;
  }

  public NewCorrespondent documentCount(Long documentCount) {
    this.documentCount = documentCount;
    return this;
  }

  /**
   * Get documentCount
   * @return documentCount
  */
  
  @Schema(name = "document_count", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("document_count")
  public Long getDocumentCount() {
    return documentCount;
  }

  public void setDocumentCount(Long documentCount) {
    this.documentCount = documentCount;
  }

  public NewCorrespondent lastCorrespondence(OffsetDateTime lastCorrespondence) {
    this.lastCorrespondence = lastCorrespondence;
    return this;
  }

  /**
   * Get lastCorrespondence
   * @return lastCorrespondence
  */
  @Valid 
  @Schema(name = "last_correspondence", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("last_correspondence")
  public OffsetDateTime getLastCorrespondence() {
    return lastCorrespondence;
  }

  public void setLastCorrespondence(OffsetDateTime lastCorrespondence) {
    this.lastCorrespondence = lastCorrespondence;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewCorrespondent newCorrespondent = (NewCorrespondent) o;
    return equalsNullable(this.name, newCorrespondent.name) &&
        equalsNullable(this.match, newCorrespondent.match) &&
        Objects.equals(this.matchingAlgorithm, newCorrespondent.matchingAlgorithm) &&
        Objects.equals(this.isInsensitive, newCorrespondent.isInsensitive) &&
        Objects.equals(this.documentCount, newCorrespondent.documentCount) &&
        Objects.equals(this.lastCorrespondence, newCorrespondent.lastCorrespondence);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(name), hashCodeNullable(match), matchingAlgorithm, isInsensitive, documentCount, lastCorrespondence);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewCorrespondent {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    match: ").append(toIndentedString(match)).append("\n");
    sb.append("    matchingAlgorithm: ").append(toIndentedString(matchingAlgorithm)).append("\n");
    sb.append("    isInsensitive: ").append(toIndentedString(isInsensitive)).append("\n");
    sb.append("    documentCount: ").append(toIndentedString(documentCount)).append("\n");
    sb.append("    lastCorrespondence: ").append(toIndentedString(lastCorrespondence)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

