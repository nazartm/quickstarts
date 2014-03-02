@XmlSchema(namespace = "http://www.example.com/blog/api/v1",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {@XmlNs(prefix = "api", namespaceURI = "http://www.example.com/blog/api/v1")})
package tutorial.api.v1.entity;

import javax.xml.bind.annotation.*;
