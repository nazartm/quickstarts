@XmlSchema(namespace = "http://www.example.com/blog/api/v2",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {@XmlNs(prefix = "api", namespaceURI = "http://www.example.com/blog/api/v2")})
package tutorial.api.v2.entity;

import javax.xml.bind.annotation.*;
