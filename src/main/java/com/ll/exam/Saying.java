package com.ll.exam;

import java.util.Map;

class Saying{
    String saying;
    String author;
    int id;

    public Saying(String saying, String author, int id) {
        this.saying = saying;
        this.author = author;
        this.id = id;
    }


    @Override
    public String toString() {
        return "WiseSaying{" +
                "id=" + id +
                ", content='" + saying + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
    public String toJson() {
        return """
                {
                    "id": %d,
                    "content": "%s",
                    "author": "%s"
                }
                """
                .stripIndent()
                .formatted(id, saying, author)
                .trim();
    }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Saying)) return false;

           Saying other = (Saying) o;

            if (this.id != other.id) return false;
            if (!this.saying.equals(other.saying)) return false;
            if (!this.author.equals(other.author)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (saying != null ? saying.hashCode() : 0);
            result = 31 * result + (author != null ? author.hashCode() : 0);
            return result;
        }
    }




